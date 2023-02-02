import {
    deleteCartGame,
    fetchCartGames,
    updateCartGames,
} from './../actions/cartAction';
import { PayloadAction, createSlice } from '@reduxjs/toolkit';
import { IGame } from './../../models/IGame';

interface cartState {
    games: IGame[];
    loading: 'idle' | 'pending' | 'succeeded' | 'failed';
    error: string;
    selectedGames: IGame[];
}

const initialState: cartState = {
    games: [],
    loading: 'idle',
    error: '',
    selectedGames: [],
};

const cartSlice = createSlice({
    name: 'cart',
    initialState,
    reducers: {
        selectGame(state, action: PayloadAction<IGame>) {
            state.selectedGames.push(action.payload);
        },
        unselectGame(state, action: PayloadAction<IGame>) {
            state.selectedGames = state.selectedGames.filter(
                (game) => game.id !== action.payload.id
            );
        },
        unselectAllGames(state) {
            state.selectedGames = [];
        },
    },
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
            .addCase(updateCartGames.fulfilled, (state) => {
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

export const { selectGame, unselectGame, unselectAllGames } = cartSlice.actions;

export default cartSlice.reducer;
