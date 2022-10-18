import axios from "axios";
import {BASE_AUTH_URL} from "../constants/baseAuthUrl";

const $authApi = axios.create({
    baseURL:BASE_AUTH_URL
})

$authApi.interceptors.request.use((config) => {
    if (config.headers === undefined) {
        config.headers = {};
    }
    config.headers.Authorization = `Bearer ${localStorage.getItem("token")}`
    return config
})

export default $authApi