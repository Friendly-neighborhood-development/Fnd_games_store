import {createAsyncThunk} from "@reduxjs/toolkit";
import {GameService} from "../../services/GameService";

interface fetchGamesProps {
    page: number,
    pageSize: number,
    sortField: string,
    ascOrder: boolean
}

export const fetchGames = createAsyncThunk("games/catalogue",
    async ({page, pageSize, sortField, ascOrder}: fetchGamesProps) => {
        const res = await GameService.fetchGames(page, pageSize, sortField, ascOrder)
        return res.data
    })

