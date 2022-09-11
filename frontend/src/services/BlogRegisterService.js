import axios from "axios";

//Java Backedten gelen API address
const BLOG_REGISTER_API_BASE_URL="/api/v.1/blog/registers";

//Blog Register Class
class BlogRegisterServices {

    //Register Create
    createBlogRegister(blogRegisterDto){
        return axios.post(BLOG_REGISTER_API_BASE_URL,blogRegisterDto);
    }
}
export default new BlogRegisterServices()