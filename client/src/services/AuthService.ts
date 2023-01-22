import {AxiosResponse} from "axios";
import {SignInResponse, SignUpResponse} from "../models/response/Auth";
import {IUser} from "../models/IUser";
import $api from "../http/api";

export interface signUpProps extends IUser {
    email: string
}

export class AuthService {
    static signIn(user: IUser): Promise<AxiosResponse<SignInResponse>> {
        return $api.post('/login/v1/authorization', user)
    }

    static signUp({password, username, email}: signUpProps): Promise<AxiosResponse<SignUpResponse>> {
        return $api.post('/login/v1/registration', {username, password, email})
    }
}