import React, { useEffect, useState } from 'react';
import { MainLayout } from '../components/layouts/MainLayout';
import { useNavigate, useParams } from 'react-router-dom';
import { useAppDispatch, useAppSelector } from '../hooks/redux';
import { fetchOneGame } from '../store/actions/gameAction';
import { GamePrice } from '../components/games/game/GamePrice';
import { PrimaryButton } from '../components/UI/PrimaryButton';
import { GameSpecificationRow } from '../components/games/game/GameSpecificationRow';
import { clearGameData } from '../store/reducers/gameSlice';
import { fetchCartGames, updateCartGames } from '../store/actions/cartAction';
import { DisabledButton } from '../components/UI/DisabledButton';
import { selectGame } from '../store/reducers/cartSlice';

const GameName = () => {
    const { name } = useParams();
    const navigate = useNavigate();
    const dispatch = useAppDispatch();
    const { game, loading } = useAppSelector((state) => state.game);
    const { userId } = useAppSelector((state) => state.auth);
    const cart = useAppSelector((state) => state.cart);
    const [isInCart, setIsInCart] = useState<boolean>(false);

    useEffect(() => {
        if (!name) navigate('/error');
        else dispatch(fetchOneGame(name));
        setIsInCart(!!cart.games.find((g) => g.name === name));
        return () => {
            dispatch(clearGameData());
        };
    }, []);

    const addToCart = async () => {
        await dispatch(
            updateCartGames({
                games: [game, ...cart.games],
                userId,
            })
        );
        setIsInCart(true);
        dispatch(selectGame(game));
        dispatch(fetchCartGames({ userId }));
    };

    if (loading === 'failed') {
        navigate('/error');
    }

    return (
        <MainLayout>
            <h1 className={'text-3xl'}>{game.name}</h1>
            <div className={'flex flex-col md:flex-row'}>
                <div className={'md:w-3/5 lg:w-2/3 md:pr-5 lg:pr-10'}>
                    <div
                        className={
                            'mb-3 min-w-full max-h-96 overflow-hidden bg-gradient-to-b from-sky-400/20 to-blue-700/20 flex justify-center rounded-lg'
                        }
                    >
                        <img
                            className={'md:rounded-lg lg:w-72'}
                            src={game?.base64Image}
                        />
                    </div>
                    <div className={'hidden md:block'}>{game?.description}</div>
                </div>
                <div className={'md:w-2/5 lg:w-1/3'}>
                    <div
                        className={
                            'flex flex-col-reverse md:flex-col space-y-4'
                        }
                    >
                        <div className={'space-y-4 mt-4 lg:mt-0'}>
                            <GameSpecificationRow
                                title={'genre'}
                                arrayValue={game.genre}
                            />
                            <GameSpecificationRow
                                title={'developer'}
                                value={game.developer?.name}
                            />
                            <GameSpecificationRow
                                title={'publisher'}
                                value={game.publisher?.name}
                            />
                            <GameSpecificationRow
                                title={'features'}
                                arrayValue={game.features}
                            />
                            <GameSpecificationRow
                                title={'platform'}
                                arrayValue={game.platform}
                            />
                            <GameSpecificationRow
                                title={'release date'}
                                value={game.releaseDate}
                            />
                        </div>
                        <div className={'space-y-4'}>
                            <GamePrice
                                price={game?.price}
                                discount={game?.discount}
                            />
                            {isInCart ? (
                                <DisabledButton>Already in cart</DisabledButton>
                            ) : (
                                <PrimaryButton onClick={addToCart}>
                                    Add to cart
                                </PrimaryButton>
                            )}
                        </div>
                    </div>
                    <div className={'md:hidden mt-3'}>{game?.description}</div>
                </div>
            </div>
        </MainLayout>
    );
};

export default GameName;
