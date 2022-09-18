import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';

//Yeni REgister
import BlogRegister from './component/BlogRegister';

import OtherLanguageResuable from './component/OtherLanguageResuable';

//Dil Seçeneği
import './i18n'


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <div>
       <BlogRegister />
        <OtherLanguageResuable/>
    </div>

    {/* <div>
       <BlogLogin />
       <OtherLanguageResuable/>
    </div> */}
   
  </React.StrictMode>
);

reportWebVitals();
