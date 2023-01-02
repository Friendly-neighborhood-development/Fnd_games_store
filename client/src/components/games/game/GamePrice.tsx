import React, {FC} from 'react';
import {IGame} from "../../../models/IGame";

interface GamePriceProps {
    price: number
    discount: number
}

export const GamePrice: FC<GamePriceProps> = ({price, discount}) => {
    return (
        <div className={"text-sm"}>
            {price === 0
                ? <div>Бесплатно</div>
                : (discount
                    ? <div className={"flex justify-between items-center"}>
                                        <span
                                            className={"flex items-center p-2 bg-blue-600 rounded-md text-xs text-white dark:bg-sky-300/[0.15] dark:text-sky-400"}
                                        >
                                            -{discount}%
                                        </span>
                        <div className={"ml-2 flex-wrap flex justify-end items-center"}>
                            <div className={"line-through text-slate-400"}>{price} ₽</div>
                            <div className={"ml-2 dark:text-slate-200"}>
                                {+(price - price * discount / 100).toFixed(2)} ₽
                            </div>
                        </div>
                    </div>
                    : <div className={"dark:text-slate-200"}>{price} ₽</div>)}
        </div>
    );
}
