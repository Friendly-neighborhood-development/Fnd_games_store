import { AxiosResponse } from 'axios';
import { IGame } from './../models/IGame';
import $api from '../http/api';

export interface accessCartProps {
    userId: string;
}

export interface updateCartGamesProps extends accessCartProps {
    games: IGame[];
}

export interface deleteCartGameProps extends accessCartProps {
    games: IGame[];
    gameToDelete: IGame;
}

export class CartService {
    static fetchCartGames({
        userId,
    }: accessCartProps): Promise<AxiosResponse<IGame[]>> {
        userId = 'user' + userId;
        return $api.post<IGame[]>('cart/v1/content', { userId });
    }
    static updateCartGames({
        userId,
        games,
    }: updateCartGamesProps): Promise<AxiosResponse<IGame[]>> {
        userId = 'user' + userId;
        const bodyParams = {
            userId,
            gameData: games,
        };
        return $api.post<IGame[]>('cart/v1/update', bodyParams);
    }
}
