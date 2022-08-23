import React, {FC, memo} from 'react';
import GameCard from "./GameCard";
import {IGame} from "../models/IGame";
import {ChevronRightIcon} from "@heroicons/react/outline";

interface GamesCategoryProps {
    title: string
    games: Array<IGame>
}

const GamesCategory: FC<GamesCategoryProps> = memo(({title, games}) => {
    return (
        <section className={"w-full"}>
            <div className={"flex justify-start my-4 "}>
                <span className={"flex items-center cursor-pointer hover:text-blue-600 dark:hover:text-sky-500 dark:text-slate-100"}>
                    <span className={"text-xl ml-4"}>{title}</span>
                    <span className={"ml-1/2"}>
                        <ChevronRightIcon className={"w-4 h-4 "}/>
                    </span>
                </span>
            </div>
            <div className={"flex lg:flex-none w-full overflow-x-auto lg:overflow-x-visible lg:grid lg:grid-cols-4 xl:grid-cols-5 lg:gap-4"}>
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