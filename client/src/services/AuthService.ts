import {AxiosResponse} from "axios";
import {AuthResponse} from "../models/response/AuthResponse";
import {IUser} from "../models/IUser";
import $authApi from "../http/authApi";

export class AuthService {
    static auth(user: IUser):Promise<AxiosResponse<AuthResponse>>{
        return $authApi.post('/login/v1/authorization', user)
    }
}