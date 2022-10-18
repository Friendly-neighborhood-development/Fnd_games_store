import React, {FC, memo} from 'react';
import {IGame} from "../models/IGame";
import {Link} from "react-router-dom";

interface GameCardProps extends IGame {
    skeleton?: boolean
}

const GameCard: FC<GameCardProps> = memo(({name, description, base64Image, price, discount, skeleton = false}) => {
    return (
        <>
            {skeleton
                ? <h1>{skeleton}</h1>
                : <Link to={`/games/${name}`}
                        className={"flex flex-wrap pb-4 bg-white  justify-between lg:shadow-md rounded-lg lg:overflow-hidden lg:before:block lg:before:absolute lg:before:-inset-1 lg:hover:before:bg-gray-400/10 dark:lg:hover:before:bg-gray-200/10 lg:relative lg:inline-block dark:bg-slate-800/50"}>
                    <div
                        className={"h-72 md:h-56 w-60 lg:w-full overflow-hidden flex justify-center items-center mb-4 rounded-sm"}>
                        <img className={"w-full pointer-events-none"} src={base64Image} alt={"game picture"}/>
                    </div>
                    <div className={"w-full px-2"}>
                        <div
                            className={"h-10 text-ellipsis whitespace-nowrap overflow-hidden dark:text-gray-200"}>{name}</div>
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
                </Link>
            }
        </>

    );
});

export default GameCard;