import {AxiosResponse} from "axios";
import {AuthResponse} from "../models/response/AuthResponse";
import {IUser} from "../models/IUser";
import $api from "../http/api";

export class AuthService {
    static signIn(user: IUser):Promise<AxiosResponse<AuthResponse>>{
        return $api.post('/login/v1/authorization', user)
    }

}