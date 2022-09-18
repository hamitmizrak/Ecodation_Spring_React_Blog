//rfc => React Function Component.
//rcc => React Class Component.
//rsc => React Stateles Component (state olmayan).
import React from 'react';

// Dil secenegi
import { withTranslation } from 'react-i18next';
import BlogRegisterService from '../services/BlogRegisterService';

//Funksiyon komponent
function OtherLanguageResuable(props) {

    //Bayraklar 
    const internationalizationLanguage = language => {
        const { i18n } = props;
        i18n.changeLanguage(language);

        //Hem java tarafından hemde frontend tarafından değişiklik yaptık.
        BlogRegisterService .otherLanguageServices(language);
    }

    //render
    return (
        <div className="container">
            <img src="../../images/flags/tr.png" alt="TR" onClick={() => internationalizationLanguage('tr')} />
            <img src="../../images/flags/en.png" alt="EN" onClick={() => internationalizationLanguage('en')} />
        </div>
    );
}
// export default UserRegister
//  Higher Order Component: monad componenti başka bir componentin içine  ekleyip oradanda yeni sonuclar elde etmek
export default withTranslation()(OtherLanguageResuable)

