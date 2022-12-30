import {createSlice} from "@reduxjs/toolkit";
import {auth} from "../actions/authAction";


interface AuthState {
    token: string
    userId: string
    loading: "idle" | "pending" | "succeeded" | "failed"
    error: string
    isAuth: boolean
}

const initialState: AuthState = {
    token: "",
    userId: "",
    loading: "idle",
    error: "",
    isAuth: false
}

export const authSlice = createSlice({
    name: "auth",
    initialState,
    reducers: {},
    extraReducers:(builder) =>{
        builder.addCase(auth.pending, (state) => {
            state.loading = "pending"
        })
            .addCase(auth.fulfilled, (state, action) => {
                state.loading = "succeeded"
                state.token = action.payload.token
                state.userId = action.payload.userId
                state.isAuth = true
                localStorage.setItem("token", state.token)
                localStorage.setItem("userId", state.userId)
            })
            .addCase(auth.rejected, (state, action) => {
                state.loading = "failed"
                console.log(action.error)
            })
    }
})


export default authSlice.reducer