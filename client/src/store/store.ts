import {configureStore} from "@reduxjs/toolkit";
import counterReducer from "./reducers/counterSlice";
import gameReducer from "./reducers/gameSlice"

export const store = configureStore({
    reducer:{
        counter: counterReducer,
        game: gameReducer
    }
})

export type RootState = ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch