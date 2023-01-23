import {
    CartService,
    accessCartProps,
    updateCartProps,
} from './../../services/CartService';
import { createAsyncThunk } from '@reduxjs/toolkit';

export const fetchCartGames = createAsyncThunk(
    'cart/fetchGames',
    async (props: accessCartProps) => {
        const res = await CartService.fetchGames(props);
        return res.data;
    }
);

export const updateCartGames = createAsyncThunk(
    'cars/updateGames',
    async (props: updateCartProps) => {
        const res = await CartService.updateCart(props);
        return res.data;
    }
);
