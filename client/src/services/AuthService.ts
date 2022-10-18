import $authApi from "../http/authApi";
import {AxiosResponse} from "axios";
import {AuthResponse} from "../models/response/AuthResponse";

export class AuthService {
    static async login(username: string, password: string): Promise<AxiosResponse<AuthResponse>> {
        return $authApi.post<AuthResponse>("/login", {username, password})
    }
    static async signup(username: string, password: string): Promise<AxiosResponse<AuthResponse>> {
        return $authApi.post<AuthResponse>("/signup", {username, password})
    }
    static async logout(): Promise<void> {
        return $authApi.post("/logout")
    }

}