import {createSlice} from "@reduxjs/toolkit";
import {signIn, signUp} from "../actions/authAction";
import {useAppDispatch} from "../../hooks/redux";

interface AuthState {
    token: string;
    userId: string;
    loading: "idle" | "pending" | "succeeded" | "failed";
    error: string;
    isAuth: boolean;
}

const initialState: AuthState = {
    token: "",
    userId: "",
    loading: "idle",
    error: "",
    isAuth: false,
};

export const authSlice = createSlice({
    name: "auth",
    initialState,
    reducers: {
        signOut: (state) => {
            state.isAuth = initialState.isAuth;
            state.userId = initialState.userId;
            state.token = initialState.token;
            state.loading = initialState.loading;
            localStorage.removeItem("token");
            localStorage.removeItem("userId");
            localStorage.removeItem("isAuth");
        },
        checkAuth: (state) => {
            const isAuth = localStorage.getItem("isAuth");
            if (isAuth) state.isAuth = JSON.parse(isAuth);
            const token = localStorage.getItem("token");
            if (token) state.token = token;
            const userId = localStorage.getItem("userId");
            if (userId) state.userId = userId;
        },
        setDefaultAuth: (state) => {
            state.token = initialState.token;
            state.userId = initialState.userId;
            state.loading = initialState.loading;
            state.error = initialState.error;
            state.isAuth = initialState.isAuth;
        },
    },
    extraReducers: (builder) => {
        builder
            .addCase(signIn.pending, (state) => {
                state.loading = "pending";
            })
            .addCase(signIn.fulfilled, (state, action) => {
                state.loading = "succeeded";
                state.token = action.payload.token;
                state.userId = action.payload.userId;
                state.isAuth = true;
                localStorage.setItem("token", state.token);
                localStorage.setItem("userId", state.userId);
                localStorage.setItem("isAuth", JSON.stringify(state.isAuth));
            })
            .addCase(signIn.rejected, (state, action) => {
                state.loading = "failed";
                console.log(action.error);
            });

        builder.addCase(signUp.pending, (state) => {
            state.loading = "pending"
        }).addCase(signUp.fulfilled, (state, action) => {
            state.loading = "succeeded"
            state.userId = action.payload.userId
        }).addCase(signUp.rejected, (state, action) => {
            state.loading = "failed"
            console.log(action.error)
        })
    },
});

export default authSlice.reducer;

export const {signOut, checkAuth, setDefaultAuth} = authSlice.actions;
