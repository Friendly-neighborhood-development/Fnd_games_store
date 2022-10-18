import {Dialog, Transition} from '@headlessui/react';
import React, {FC, Fragment, useEffect, useState} from 'react';
import {ShoppingCartIcon} from "@heroicons/react/24/outline";
import {useAppDispatch, useAppSelector} from "../../hooks/redux";
import {fetchGames} from "../../store/actions/gameAction";
import CartRow from "./CartRow";

interface CartProps {
}

const Cart: FC<CartProps> = () => {
    const [isOpen, setIsOpen] = useState(false)
    let {games} = useAppSelector(state => state.game)
    games = games.slice(7)
    const dispatch = useAppDispatch()
    useEffect(() => {
        dispatch(fetchGames())
    }, [])

    function closeCart() {
        setIsOpen(false)
    }

    function openCart() {
        setIsOpen(true)
    }

    return (
        <>
            <div onClick={openCart} className={"cursor-pointer rounded-full bg-white border-solid border-gray-300 border h-10 w-10 flex justify-center items-center hover:bg-gray-200/30 dark:border-slate-600 dark:hover:bg-slate-500/50 dark:bg-slate-800"}>
                <ShoppingCartIcon className={"text-slate-500 w-3/5 h-3/5 dark:text-slate-300"} />
            </div>

            <Transition appear show={isOpen} as={Fragment}>
                <Dialog as="div" className="relative z-10" onClose={closeCart}>
                    <Transition.Child
                        as={Fragment}
                        enter="ease-out duration-300"
                        enterFrom="opacity-0"
                        enterTo="opacity-100"
                        leave="ease-in duration-200"
                        leaveFrom="opacity-100"
                        leaveTo="opacity-0"
                    >
                        <div className="fixed inset-0 bg-black bg-opacity-25"/>
                    </Transition.Child>

                    <div className="fixed inset-0 overflow-y-auto">
                        <div className="flex min-h-full items-center justify-center p-4 text-center">
                            <Transition.Child
                                as={Fragment}
                                enter="ease-out duration-300"
                                enterFrom="opacity-0 scale-95"
                                enterTo="opacity-100 scale-100"
                                leave="ease-in duration-200"
                                leaveFrom="opacity-100 scale-100"
                                leaveTo="opacity-0 scale-95"
                            >
                                <Dialog.Panel
                                    className="w-full max-w-md md:max-w-lg  transform overflow-hidden rounded-2xl bg-white p-6 text-left align-middle shadow-xl transition-all dark:bg-slate-700 dark:text-white" >
                                    <Dialog.Title
                                        as="h3"
                                        className="text-lg font-medium leading-6 text-gray-900 dark:text-white"
                                    >
                                        Your cart
                                    </Dialog.Title>
                                    <div className="mt-2 space-y-4">
                                        {games.map(game => <CartRow game={game}/> )}
                                    </div>
                                    <div className={'p-2 flex justify-end'}>
                                    </div>

                                    <div className="border-t border-slate-400 pt-4 flex justify-between items-center">
                                        <button
                                            type="button"
                                            className="inline-flex justify-center rounded-md border border-transparent bg-blue-100 px-4 py-2 text-sm font-medium text-blue-900 hover:bg-blue-200 focus:outline-none focus-visible:ring-2 focus-visible:ring-blue-500 focus-visible:ring-offset-2"
                                            onClick={closeCart}
                                        >
                                            Got it, thanks!
                                        </button>
                                        <div>
                                            Total: {games.reduce((prev, cur) => prev + cur.price, 0)} ₽
                                        </div>
                                    </div>
                                </Dialog.Panel>
                            </Transition.Child>
                        </div>
                    </div>
                </Dialog>
            </Transition>
        </>
    );
};

export default Cart;