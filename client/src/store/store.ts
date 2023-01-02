import {configureStore} from "@reduxjs/toolkit";
import gameReducer from "./reducers/gameSlice"
import gamesReducer from "./reducers/gamesSlice"
import authReducer from "./reducers/authSlice"

export const store = configureStore({
    reducer:{
        game: gameReducer,
        games: gamesReducer,
        auth: authReducer
    }
})

export type RootState = ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch