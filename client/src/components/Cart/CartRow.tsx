import React, {FC} from 'react';
import {IGame} from "../../models/IGame";

interface CartRowProps {
    game: IGame
}

const CartRow: FC<CartRowProps> = ({game}) => {
    const {name, price, base64Image, discount} = game
    return (
        <div className={"flex p-2 lg:p-4 space-x-4 dark:bg-slate-800 rounded-lg"}>
            <div className={"w-32 h-32 rounded overflow-hidden flex items-center justify-center"}>
                <img src={base64Image} alt={name}/>
            </div>
            <div className={"flex flex-col justify-between"}>
                <span>{name}</span>
                <div className={"text-sm"}>
                    {price === 0
                        ? <div>Бесплатно</div>
                        : (discount
                            ? <div className={"flex justify-between items-center"}>
                                        <span
                                            className={"flex items-center p-2 bg-blue-600 dark:bg-sky-300/[0.15] text-white dark:text-sky-400 rounded-md text-xs"}
                                        >
                                            -{discount}%
                                        </span>
                                <div className={"ml-2 flex-wrap flex justify-end items-center"}>
                                    <div className={"line-through text-slate-400"}>{price} ₽</div>
                                    <div className={"dark:text-slate-200 ml-2"}>
                                        {+(price - price * discount / 100).toFixed(2)} ₽
                                    </div>
                                </div>
                            </div>
                            : <div className={"dark:text-slate-200"}>{price} ₽</div>)}
                </div>
            </div>

        </div>
    );
};

export default CartRow;