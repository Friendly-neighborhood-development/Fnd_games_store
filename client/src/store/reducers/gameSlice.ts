import {IGame} from "../../models/IGame";
import {createSlice} from "@reduxjs/toolkit";
import {fetchOneGame} from "../actions/gameAction";

interface gameState {
    game: IGame
    loading: "idle" | "pending" | "succeeded" | "failed"
    error: string
}

const initialState: gameState = {
    game: {} as IGame,
    loading: "idle",
    error: ""
}

const gameSlice = createSlice({
    name: "game",
    initialState,
    reducers: {
        clearGameData:(state) => {
            state.game = initialState.game
        }
    },
    extraReducers: (builder) => {
        builder.addCase(fetchOneGame.pending, (state) => {
            state.loading = "pending"
        }).addCase(fetchOneGame.fulfilled, (state, action) => {
            state.loading = "succeeded"
            state.game = action.payload
        }).addCase(fetchOneGame.rejected, (state, action) => {
            state.loading = "failed"
            console.log(action.error)
        })
    }
})

export default gameSlice.reducer

export const {clearGameData} = gameSlice.actions