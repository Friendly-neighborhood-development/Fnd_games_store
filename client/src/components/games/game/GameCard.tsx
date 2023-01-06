import React, {FC, memo} from 'react';
import {Link} from "react-router-dom";
import {GamePrice} from "./GamePrice";
import {IGame} from "../../../models/IGame";


const GameCard: FC<IGame> = memo(({name, base64Image, price, discount}) => {
    return (
        <Link to={`/games/${name}`}
              className={"flex flex-wrap pb-4 bg-white justify-between lg:shadow-md rounded-lg lg:overflow-hidden lg:before:block lg:before:absolute lg:before:-inset-1 lg:hover:before:bg-gray-400/10 dark:lg:hover:before:bg-gray-200/10 lg:relative lg:inline-block dark:bg-slate-800/50"}>
            <div
                className={"h-72 md:h-56 w-60 lg:w-full overflow-hidden flex justify-center items-center mb-4 rounded-sm"}>
                <img className={"w-full pointer-events-none"} src={base64Image} alt={"game picture"}/>
            </div>
            <div className={"w-full px-2"}>
                <div
                    className={"h-10 text-ellipsis whitespace-nowrap overflow-hidden dark:text-gray-200"}>{name}</div>
                <GamePrice price={price} discount={discount}/>
            </div>
        </Link>
    );
});

export default GameCard;
