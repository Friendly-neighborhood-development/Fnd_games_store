import {IGame} from "../../models/IGame";
import {createSlice, PayloadAction} from "@reduxjs/toolkit";
import {gameSlice} from "./gameSlice";


interface authState{
    isLoading: boolean,
    error: string
}

const initialState:authState ={
    isLoading: false,
    error:""
}

export const authSlice = createSlice({
    name:"auth",
    initialState,
    reducers:{
        authRequest(state) {
            state.isLoading = true
        },
        authRequestSuccess(state) {
            state.isLoading = false
            state.error = ""
        },
        authRequestError(state, action:PayloadAction<string>) {
            state.isLoading = false
            state.error = action.payload
        },
    }
})

export const {authRequest, authRequestSuccess, authRequestError} = authSlice.actions

export default authSlice.reducer