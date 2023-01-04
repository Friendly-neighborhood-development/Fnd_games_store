import {IGame} from "../../models/IGame";
import {createSlice} from "@reduxjs/toolkit";
import {fetchGames} from "../actions/gamesAction";

interface GamesState {
    games: IGame[],
    loading: "idle" | "pending" | "succeeded" | "failed",
    error: string
}

const initialState: GamesState = {
    games: [],
    loading: "idle",
    error: ""
}

export const gamesSlice = createSlice({
    name: "games",
    initialState,
    reducers: {
    },
    extraReducers:(builder) =>{
        builder.addCase(fetchGames.pending, (state) => {
            state.loading = "pending"
        })
            .addCase(fetchGames.fulfilled, (state, action) => {
                state.loading = "succeeded"
                state.games = action.payload
            })
            .addCase(fetchGames.rejected, (state, action) => {
                state.loading = "failed"
                console.log(action.error)
            })
    }
})


export default gamesSlice.reducer