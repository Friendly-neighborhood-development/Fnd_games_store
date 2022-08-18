import React, {FC, memo} from 'react';
import GameCard from "./GameCard";
import {game} from "../types/Games";
import {ChevronRightIcon} from "@heroicons/react/outline";

interface GamesCategoryProps {
    title: string
    games: Array<game>
}

const GamesCategory: FC<GamesCategoryProps> = memo(({title, games}) => {
    return (
        <section className={"w-full"}>
            <div className={"flex justify-start my-4 "}>
                <span className={"flex items-center cursor-pointer hover:text-blue-600 dark:hover:text-sky-500 dark:text-slate-100"}>
                    <span className={"text-xl ml-4"}>{title}</span>
                    <span className={"ml-1"}>
                        <ChevronRightIcon className={"w-4 h-4 "}/>
                    </span>
                </span>
            </div>
            <div className={"flex overflow-x-auto lg:flex-wrap justify-between w-full"}>
                {games.map(game =>
                    <GameCard
                        {...game}
                        key={game.id}
                    />)}
            </div>
        </section>

    );
})

export default GamesCategory;