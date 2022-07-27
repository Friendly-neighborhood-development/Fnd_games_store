import React, {FC, memo} from 'react';
import GameCard from "./GameCard";
import {gameProps} from "../types/Games";
import {ChevronRightIcon} from "@heroicons/react/outline";

interface GamesCategoryProps{
    title: string
    games: Array<gameProps>
}

const GamesCategory: FC<GamesCategoryProps> = memo(({title, games}) => {
    return (
        <>
            <div className={"mb-2 flex justify-start w-full items-center mt-8 mb-5"}>
                <span className={"text-xl"}>{title}</span>
                <span className={"ml-1 mt-1"}>
                    <ChevronRightIcon className={"w-2.5 h-2.5 md:w-4 md:h-4"}/>
                </span>
            </div>
            <div className={"flex overflow-x-auto lg:flex-wrap justify-between w-full"}>
                {games.map(game =>
                    <GameCard
                        {...game}
                        key={game.id}
                    />)}
            </div>
        </>

    );
})

export default GamesCategory;