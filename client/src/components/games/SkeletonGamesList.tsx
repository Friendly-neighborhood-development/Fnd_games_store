import React, {FC} from 'react';
import {GameCardLoader} from "./game/GameCardLoader";
import {defaultFilterTitles} from "../../constants/filter";

export const SkeletonGamesList: FC = () => {
    const games = Array(defaultFilterTitles.pageSize).fill({})
    return (
        <>
            {games.map((_) => (
                <GameCardLoader key={Math.random()}/>
            ))}
        </>
    );
}
