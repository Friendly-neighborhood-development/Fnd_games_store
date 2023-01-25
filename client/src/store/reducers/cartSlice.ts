import { useAppDispatch, useAppSelector } from './../../hooks/redux';
import {
    deleteCartGame,
    fetchCartGames,
    updateCartGames,
} from './../actions/cartAction';
import { createSlice } from '@reduxjs/toolkit';
import { IGame } from './../../models/IGame';

interface cartState {
    games: IGame[];
    loading: 'idle' | 'pending' | 'succeeded' | 'failed';
    error: string;
}

const initialState: cartState = {
    games: [],
    loading: 'idle',
    error: '',
};

const cartSlice = createSlice({
    name: 'cart',
    initialState,
    reducers: {},
    extraReducers(builder) {
        builder
            .addCase(fetchCartGames.pending, (state) => {
                state.loading = 'pending';
            })
            .addCase(fetchCartGames.fulfilled, (state, action) => {
                state.games = action.payload;
                state.loading = 'succeeded';
            })
            .addCase(fetchCartGames.rejected, (state, action) => {
                state.loading = 'failed';
                console.log(action.error);
            });
        builder
            .addCase(updateCartGames.pending, (state) => {
                state.loading = 'pending';
            })
            .addCase(updateCartGames.fulfilled, (state, action) => {
                state.games = action.payload;
                state.loading = 'succeeded';
            })
            .addCase(updateCartGames.rejected, (state, action) => {
                state.loading = 'failed';
                console.log(action.error);
            });
        builder
            .addCase(deleteCartGame.pending, (state) => {
                state.loading = 'pending';
            })
            .addCase(deleteCartGame.fulfilled, (state) => {
                state.loading = 'succeeded';
            })
            .addCase(deleteCartGame.rejected, (state, action) => {
                state.loading = 'failed';
                console.log(action.error);
            });
    },
});

export default cartSlice.reducer;
