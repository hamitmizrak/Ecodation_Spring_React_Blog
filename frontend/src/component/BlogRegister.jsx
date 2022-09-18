// rcc==> TAB
// react component ==> Class(statefull) ve Function(stateless) olmak üzere
// Class statefull(durumlu) yani veri bilgileri tutup backentte göndermek
// Classlarda mutlaka render eklemeliyiz.
// import axios from 'axios';
import React, {Component} from 'react';
//axios services icin

// Dil secenegi
import { withTranslation } from 'react-i18next';
import BlogRegisterService from '../services/BlogRegisterService';
import InputBlogRegister from './InputBlogRegister';

//Resuability


//class UserRegister (export en alta yazdım)
class BlogRegister extends Component {
  constructor(props) {
    super(props);

    //default value(Class Componentte olmalıdır)
    //input name ile buradaki değerler aynı olmalıdır
    this.state = {
      username: null,
      email: null,
      password: null,
      passwordRepeat: null,
      apiResultErrors: {}
    }
    //bind function
    this.onClickregister = this.onClickregister.bind(this);
    this.onChangeInput = this.onChangeInput.bind(this);

    //bind
    this.internationalizationLanguage = this.internationalizationLanguage.bind(this);
  }

  //Bayraklar
  internationalizationLanguage = language => {
    const { i18n } = this.props;
    i18n.changeLanguage(language);
    //Hem java tarafından hemde frontend tarafından değişiklik yaptık
    BlogRegisterService.otherLanguageServices(language);
  }

  /*fonkisyonlar*/
  /*1.YOL*/
  /* Submit Button: async await */
  onClickregister = async (event) => {
    /*browsera bizim yerimize submit yapmasını kapattım. */
    event.preventDefault();
    //postman gönderilecek verinin aynısı
    const {username, email, password} = this.state;
    const BODY = {
      username,
      email,
      password
    }


    try {
      const response = await BlogRegisterService.createRegister(BODY);
    } catch (error) {
      console.log(error.response.data);
      //Her gelen hata validation olmayabilir
      if (error.response.data.validationData) {
        this.setState({apiResultErrors: error.response.data.validationData})
      }
    }
    this.setState({submitCloseMultipleRequest: false});

  }

  /*Input ==> onChange: inputlardaki her bir hareketi yakalama*/
  onChangeInput = (event) => {
    const { t } = this.props;
    const {name, value} = event.target;
    const apiResultErrors = {...this.state.apiResultErrors};
    this.setState({
      [name]: value,
      apiResultErrors
    })
  }

  //render
  render() {
    /*javascript kodlarını buraya yazıyorum*/
    /*object destructing*/
    const { apiResultErrors} = this.state;
    const {username, email, password} = apiResultErrors;
    return (
        <div className="container">
          <div className="row">
            <form>
              <h1 className="mt-5 text-center">{this.props.t('Login Register')}</h1>

              <InputBlogRegister type="text" label={this.props.t('username') }   name="username" id="username"
                                 placeholder="Kullanıcı adı" onChangeInput={this.onChangeInput}
                                 error={username} focus="true"/>

              <InputBlogRegister type="text" label={this.props.t('email') }  name="email" id="email"
                                 placeholder="Kullanıcı Email" onChangeInput={this.onChangeInput}
                                 error={email}/>

              <InputBlogRegister  type="password" label={this.props.t('password') }  name="password" id="password"
                                 placeholder="Kullanıcı Şifresi" onChangeInput={this.onChangeInput}
                                 error={password}/>

             
              <button type="reset" className="btn btn-danger me-4">Temizle</button>
          
              <button type="submit" className="btn btn-primary"
                      onClick={this.onClickregister}
                     >Gönder
              </button>
           
            </form>
          </div>
        </div>
    )
  }
}

const languageInformationData = withTranslation()(BlogRegister)
export default languageInformationData;
