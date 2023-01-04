import React, {FC} from 'react';

interface IValue {
    id: string
    name: string
}

interface GameSpecificationRowProps {
    title: string,
    arrayValue?: IValue[],
    value?: string,
}

export const GameSpecificationRow: FC<GameSpecificationRowProps> = ({title, arrayValue, value}) => {
    return (
        <div className={"flex justify-between border-b border-b-slate-800 px-2 py-1"}>
            <div className={"text-gray-600 dark:text-slate-400"}>{title}</div>
            <div>{arrayValue?.map((val) => (
                <span key={val.id}> {val.name}</span>
            ))}</div>
            {value && <div>{value}</div>}

        </div>
    );
}
