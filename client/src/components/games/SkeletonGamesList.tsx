import React, {FC} from 'react';
import {GameCardLoader} from "./game/GameCardLoader";

export const SkeletonGamesList: FC = () => {
    const games = Array(8).fill({})
    return (
        <>
            {games.map((_) => (
                <GameCardLoader key={Math.random()}/>
            ))}
        </>
    );
}
