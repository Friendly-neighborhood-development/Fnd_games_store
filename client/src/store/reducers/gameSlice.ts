import {IGame} from "../../models/IGame";
import {createSlice, PayloadAction} from "@reduxjs/toolkit";

interface GameState {
    games: IGame[],
    isLoading: boolean,
    error: string
}


const initialState: GameState = {
    games: [],
    isLoading: false,
    error: ""
}

export const gameSlice = createSlice({
    name: "games",
    initialState,
    reducers: {
        gamesFetching(state) {
            state.isLoading = true
        },
        gamesFetchingSuccess(state, action:PayloadAction<IGame[]>) {
            state.isLoading = false
            state.error = ""
            state.games = action.payload
        },
        gamesFetchingError(state, action:PayloadAction<string>) {
            state.isLoading = false
            state.error = action.payload
        },
    }
})

export default gameSlice.reducer