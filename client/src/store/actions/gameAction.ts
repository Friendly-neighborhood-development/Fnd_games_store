import {createAsyncThunk} from "@reduxjs/toolkit";
import {GameService} from "../../services/GameService";

export const fetchOneGame = createAsyncThunk("games/catalogue/gameName", async (name: string) => {
    const res = await GameService.fetchOneGame(name)
    return res.data
})