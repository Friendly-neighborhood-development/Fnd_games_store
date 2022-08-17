import React, {FC, memo} from 'react';
import GameCard from "./GameCard";
import {game} from "../types/Games";
import {ChevronRightIcon} from "@heroicons/react/outline";

interface GamesCategoryProps{
    title: string
    games: Array<game>
}

const GamesCategory: FC<GamesCategoryProps> = memo(({title, games}) => {
    return (
        <div className={"w-full"}>
            <div className={"flex justify-start w-full items-center my-4 cursor-pointer"}>
                <span className={"text-xl dark:text-slate-100 ml-4"}>{title}</span>
                <span className={"ml-1"}>
                    <ChevronRightIcon className={"w-4 h-4 text-slate-800 dark:text-slate-100"}/>
                </span>
            </div>
            <div className={"flex overflow-x-auto lg:flex-wrap justify-between w-full"}>
                {games.map(game =>
                    <GameCard
                        {...game}
                        key={game.id}
                    />)}
            </div>
        </div>

    );
})

export default GamesCategory;