import $api from "../http/api";
import {AxiosResponse} from "axios";
import {IGame} from "../models/IGame";

export class GameService{
    // тут пока не понятно, на какой именно порт слать, поэтому пока оставим
    static fetchGames(page:number, pageSize: number, sortField: string, ascOrder: boolean):Promise<AxiosResponse<IGame[]>>{
        return $api.get<IGame[]>("/games/v1/catalogue/list?",{
            params:{
                page,
                pageSize,
                sortField,
                ascOrder
            }
        })
    }

}