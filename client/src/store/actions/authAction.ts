import {AppDispatch} from "../store";
import axios from "axios";
import {authRequest, authRequestError, authRequestSuccess} from "../reducers/authSlice";
import {AuthService} from "../../services/AuthService";

export const login = (username:string, password:string) => async (dispatch:AppDispatch) => {
    try {
        dispatch(authRequest())
        const res = await AuthService.login(username, password)
        localStorage.setItem("token", res.data.token)
        dispatch(authRequestSuccess())
    } catch (e) {
        if (axios.isAxiosError(e))
            dispatch(authRequestError(e.message))
        else
            dispatch(authRequestError(`Unexpected error: ${e}`))
    }
}
export const signup = (username:string, password:string) => async (dispatch:AppDispatch) => {
    try {
        dispatch(authRequest())
        const res = await AuthService.signup(username, password)
        localStorage.setItem("token", res.data.token)
        dispatch(authRequestSuccess())
    } catch (e) {
        if (axios.isAxiosError(e))
            dispatch(authRequestError(e.message))
        else
            dispatch(authRequestError(`Unexpected error: ${e}`))
    }
}
export const logout = () => async (dispatch:AppDispatch) => {
    try {
        dispatch(authRequest())
        localStorage.removeItem("token")
        dispatch(authRequestSuccess())
    } catch (e) {
        if (axios.isAxiosError(e))
            dispatch(authRequestError(e.message))
        else
            dispatch(authRequestError(`Unexpected error: ${e}`))
    }
}
