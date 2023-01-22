import {createAsyncThunk} from "@reduxjs/toolkit";
import {AuthService, signUpProps} from "../../services/AuthService";
import {IUser} from "../../models/IUser";


export const signIn = createAsyncThunk("signIn", async (props: IUser) => {
    const res = await AuthService.signIn(props)
    return res.data
})

export const signUp = createAsyncThunk("signUp", async (props: signUpProps) => {
    const res = await AuthService.signUp(props)
    return res.data
})