import axios from "axios";
import {BASE_API_URL} from "../constants/baseApiURL";

const $api = axios.create({
    baseURL: BASE_API_URL
})

$api.interceptors.request.use((config) => {
    if (config.headers === undefined) {
        config.headers = {};
    }
    config.headers.Authorization = `Bearer ${localStorage.getItem("token")}`
    return config
})

export default $api