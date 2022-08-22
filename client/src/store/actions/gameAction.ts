import {AppDispatch} from "../store";
import axios from "axios";
import {gameSlice} from "../reducers/gameSlice";
import {BASE_SERVER_URL} from "../../constants/baseServerURL";

export const fetchGames = () =>  async (dispatch: AppDispatch) => {
    try {
        dispatch(gameSlice.actions.gamesFetching())
        // здесь с помощью generic у get можно сразу определить тип получаемых данных
        const res = await axios.get(`${BASE_SERVER_URL}/games/getAll`)
        dispatch(gameSlice.actions.gamesFetchingSuccess(res.data))
    } catch (e) {
        if (axios.isAxiosError(e))
            dispatch(gameSlice.actions.gamesFetchingError(e.message))
        else
            dispatch(gameSlice.actions.gamesFetchingError(`Unexpected error: ${e}`))
    }
}