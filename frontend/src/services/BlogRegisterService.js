import axios from "axios";
const REGISTER_API_BASE_URL = "api/v.1/blog/registers";

//Employee Class
class BlogRegisterServices {

    //Basic Authentication
    //credentisn içinde ==> username ,password
    credentions(loginObject) {
        //requestbody ==>boş olacak
        //1.URl 2.REQUESTBODY 3.OBJECT
        const email = loginObject.username;
        const password = loginObject.password;
        console.log("UserRegisterServices => " + loginObject.username + " " + loginObject.password)

        return axios.post('/api/v1.0/authentication', {
            withCredentials: true,
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            }
        }, {
            auth: {
                username: email,
                password: password
            }
        }).then(function (response) {
            console.log('Response Authenticated ');
        }).catch(function (error) {
            console.log('Error  Authentication');
        });

    };

    //CREATE sisteme header göndereceğim.
    createRegister(register) {
        return axios.post(REGISTER_API_BASE_URL, register);
    };

    //language Flag button
    otherLanguageServices(language) {
        axios.defaults.headers['accept-language'] = language;
    }
}


export default new BlogRegisterServices()