import { AxiosResponse } from 'axios';
import { IGame } from './../models/IGame';
import $api from '../http/api';

export interface accessCartProps {
    userId: string;
    token: string;
}

export interface updateCartProps extends accessCartProps {
    games: IGame[];
}

export class CartService {
    static fetchGames({
        userId,
        token,
    }: accessCartProps): Promise<AxiosResponse<IGame[]>> {
        userId = 'user' + userId;
        return $api.post<IGame[]>('cart/v1/content', { userId });
    }
    static updateCart({
        userId,
        token,
        games,
    }: updateCartProps): Promise<AxiosResponse<IGame[]>> {
        userId = 'user' + userId;
        const bodyParams = {
            userId,
            gameData: games,
        };
        return $api.post<IGame[]>('cart/v1/update', bodyParams);
    }
}
