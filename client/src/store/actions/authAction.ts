import {createAsyncThunk} from "@reduxjs/toolkit";
import {IAuth} from "../../models/IAuth";
import {AuthService} from "../../services/AuthService";


export const auth = createAsyncThunk("auth", async ({username, password}:IAuth) => {
    const res = await AuthService.auth({username, password})
    return res.data
})