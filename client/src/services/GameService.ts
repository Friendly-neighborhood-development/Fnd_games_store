import $api from "../http/api";
import {AxiosResponse} from "axios";
import {IGame} from "../models/IGame";

export default class GameService{
    // тут пока не понятно, на какой именно порт слать, поэтому пока оставим
    static fetchGames():Promise<AxiosResponse<IGame[]>>{
        return $api.get<IGame[]>("/games/getAll")
    }

}