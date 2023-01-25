import { useEffect } from 'react';
import { MainLayout } from '../components/layouts/MainLayout';
import { useAppDispatch, useAppSelector } from '../hooks/redux';
import { Link } from 'react-router-dom';
import { fetchCartGames } from '../store/actions/cartAction';
import { CartGameCard } from '../components/cart/CartGameCard';
import { CartOrderBlock } from '../components/cart/CartOrderBlock';

const Cart = () => {
    const { userId, isAuth } = useAppSelector((state) => state.auth);
    const { games } = useAppSelector((state) => state.cart);
    const dispatch = useAppDispatch();
    useEffect(() => {
        if (isAuth) dispatch(fetchCartGames({ userId }));
    }, []);

    return (
        <MainLayout>
            {isAuth ? (
                games.length ? (
                    <div className="mt-4 xl:px-32">
                        <div className="text-2xl">Cart</div>
                        <div className="flex flex-col md:flex-row">
                            <div className="md:w-3/5 divide-y ">
                                {games.map((game) => (
                                    <CartGameCard game={game} key={game.id} />
                                ))}
                            </div>
                            <CartOrderBlock />
                        </div>
                    </div>
                ) : (
                    <div className="w-full h-10 my-10 flex items-center justify-center text-xl">
                        Here will be your cart items..
                    </div>
                )
            ) : (
                <div className={'flex justify-center text-xl my-6'}>
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
