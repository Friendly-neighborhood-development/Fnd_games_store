import { IGame } from './../../models/IGame';
import {
    CartService,
    accessCartProps,
    deleteCartGameProps,
    updateCartGamesProps,
} from './../../services/CartService';
import { createAsyncThunk } from '@reduxjs/toolkit';

export const fetchCartGames = createAsyncThunk(
    'cart/fetchGames',
    async (props: accessCartProps) => {
        const res = await CartService.fetchCartGames(props);
        return res.data;
    }
);

export const updateCartGames = createAsyncThunk(
    'cart/updateGames',
    async (props: updateCartGamesProps) => {
        const res = await CartService.updateCartGames(props);
        return res.data;
    }
);

export const deleteCartGame = createAsyncThunk(
    'cart/deleteGame',
    async (props: deleteCartGameProps) => {
        props.games = props.games.filter(
            (game) => game.id !== props.gameToDelete.id
        );
        const res = await CartService.updateCartGames(props);
        return res.data;
    }
);
