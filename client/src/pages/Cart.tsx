import { useEffect } from 'react';
import { MainLayout } from '../components/layouts/MainLayout';
import { useAppDispatch, useAppSelector } from '../hooks/redux';
import { Link } from 'react-router-dom';
import { fetchCartGames } from '../store/actions/cartAction';
import { PrimaryButton } from '../components/UI/PrimaryButton';
import { GamePrice } from '../components/games/game/GamePrice';
import { XMarkIcon } from '@heroicons/react/24/outline';

const Cart = () => {
    const { token, userId, isAuth } = useAppSelector((state) => state.auth);
    const { games } = useAppSelector((state) => state.cart);
    const dispatch = useAppDispatch();
    useEffect(() => {
        if (isAuth) dispatch(fetchCartGames({ userId, token }));
    }, []);

    return (
        <MainLayout>
            {isAuth ? (
                games.length && games[0].name ? (
                    <div className="mt-4 md:mt-10 xl:px-32">
                        <div className="text-2xl">Cart</div>
                        <div className="flex flex-col md:flex-row">
                            <div className="md:w-3/5 divide-y ">
                                {games.map((game) => (
                                    <div
                                        key={game.id}
                                        className="flex md:px-2 py-4 border-slate-600/50"
                                    >
                                        <Link
                                            to={`/games/${game.name}`}
                                            className="w-40 min-w-[100px] overflow-hidden rounded-lg flex justify-center bg-gray-200 mr-4 p-2 dark:bg-slate-800"
                                        >
                                            <img src={game.base64Image} />
                                        </Link>
                                        <div className="flex justify-between w-full">
                                            <div className="flex flex-col justify-between">
                                                <div className="flex flex-col">
                                                    <div className="text-xl">
                                                        {game.name}
                                                    </div>
                                                    <div className="opacity-50 text-sm">
                                                        {game.releaseDate}
                                                    </div>
                                                </div>
                                                <div className="flex items-center">
                                                    <GamePrice
                                                        price={game.price}
                                                        discount={game.discount}
                                                    />
                                                </div>
                                            </div>
                                            <XMarkIcon className="w-6 h-6 cursor-pointer" />
                                        </div>
                                    </div>
                                ))}
                            </div>
                            <div className="md:w-2/5 md:ml-10 mt-8 md:mt-0">
                                <div className="rounded-lg bg-gray-200/50 mb-4 p-4 space-y-1 dark:bg-slate-800">
                                    <div className="flex justify-between items-end mb-2">
                                        <div className="text-lg">Total:</div>
                                        <div className="text-xl">
                                            {games
                                                .reduce(
                                                    (acc, cur) =>
                                                        acc +
                                                        cur.price -
                                                        (cur.price *
                                                            cur.discount) /
                                                            100,
                                                    0
                                                )
                                                .toFixed(2)}
                                            <span className="text-base">
                                                &#8381;
                                            </span>
                                        </div>
                                    </div>
                                    <div className="text-sm flex justify-between">
                                        <div>Games count: {games.length}</div>
                                        <div>
                                            {games
                                                .reduce(
                                                    (acc, cur) =>
                                                        acc + cur.price,
                                                    0
                                                )
                                                .toFixed(2)}
                                            &#8381;
                                        </div>
                                    </div>
                                    <div className="text-sm flex justify-between">
                                        <div>Discount:</div>
                                        <div className="text-red-400">
                                            {games
                                                .reduce(
                                                    (acc, cur) =>
                                                        acc +
                                                        (cur.discount *
                                                            cur.price) /
                                                            100,
                                                    0
                                                )
                                                .toFixed(2)}
                                            &#8381;
                                        </div>
                                    </div>
                                </div>
                                <PrimaryButton type={'submit'}>
                                    Place Order
                                </PrimaryButton>
                            </div>
                        </div>
                    </div>
                ) : (
                    <div className="w-full h-10 my-10 flex items-center justify-center text-xl">
                        Here will be your cart items..
                    </div>
                )
            ) : (
                <div className={'flex justify-center text-xl'}>
                    <Link
                        to={'/login'}
                        className={' mr-1 text-blue-600 dark:text-sky-500'}
                    >
                        Login
                    </Link>
                    to use the cart
                </div>
            )}
        </MainLayout>
    );
};

export default Cart;
