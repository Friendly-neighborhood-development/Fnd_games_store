import React, {FC, memo} from 'react';
import {game} from "../types/Games";
import {Link} from "react-router-dom";


const GameCard: FC<game> = memo(({name, description, base64Image, price, discount}) => {
    const highlightAfterClass = "after:content-[''] after:block after:absolute after:z-10 after:top-0 after:w-56 after:h-full after:bg-gray-300/30"
    return (
        <Link to={`/games/${name}`}
              className={"flex z-0 w-60 flex-wrap mr-2 lg:mr-0 lg:w-56 mb-4 bg-white dark:bg-slate-800/50 justify-between rounded-sm after:con "}>
            <div className={"h-72 md:h-56 w-60 overflow-hidden flex justify-center items-center mb-4 rounded-sm"}>
                <img className={"w-full pointer-events-none"} src={base64Image} alt={"game picture"}/>
            </div>
            <div className={"px-2 pb-2 w-full"}>
                <div className={"h-10 text-ellipsis whitespace-nowrap overflow-hidden dark:text-gray-200"}>{name}</div>
                <div className={"text-sm"}>
                    {price === 0
                        ? <div>Бесплатно</div>
                        : (discount
                            ? <div className={"flex justify-between items-center"}>
                                <span
                                    className={"flex items-center p-2 bg-blue-600 dark:bg-sky-300/[0.15] text-white dark:text-sky-400 rounded-md text-xs"}>-{discount}%</span>
                                <div className={"ml-1 flex-wrap flex justify-end items-center"}>
                                    <div className={"line-through text-slate-400"}>{price} ₽</div>
                                    <div className={"ml-1 dark:text-slate-200"}>  {+(price - price * discount / 100).toFixed(2)} ₽</div>
                                </div>
                            </div>
                            : <div className={"dark:text-slate-200"}>{price} ₽</div>)}
                </div>
            </div>
            <div className={""}>

            </div>
        </Link>
    );
});

export default GameCard;