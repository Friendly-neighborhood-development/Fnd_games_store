import {createAsyncThunk} from "@reduxjs/toolkit";
import {GameService} from "../../services/GameService";


export const fetchGames = createAsyncThunk("games/catalogue", async({page, pageSize, sortField, ascOrder}:{page:number, pageSize: number, sortField: string, ascOrder: boolean})=>{
    const res = await GameService.fetchGames(page, pageSize, sortField, ascOrder)
    return res.data
})