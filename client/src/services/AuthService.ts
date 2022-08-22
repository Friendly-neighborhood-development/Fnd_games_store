import $api from "../http";
import {AxiosResponse} from "axios";
import {AuthResponse} from "../models/response/AuthResponse";

export default class AuthService{
    static async login(username: string, password:string):Promise<AxiosResponse<AuthResponse>>{
        return $api.post<AuthResponse>("/login", {username, password})
    }

    static async register(username: string, password:string):Promise<AxiosResponse<AuthResponse>>{
        return $api.post<AuthResponse>("/register", {username, password})
    }

    static async logout(): Promise<AxiosResponse<AuthResponse>> {
        return $api.post<AuthResponse>("/logout")
    }

}