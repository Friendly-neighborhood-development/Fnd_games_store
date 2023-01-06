import React, {FC, Fragment} from 'react';
import {Listbox} from "@headlessui/react";
import {CheckIcon, ChevronDownIcon} from "@heroicons/react/20/solid";

interface IValue{
    id: number
    title: string
}

interface GamesFilterField {
    title: string
    selectedValue: any
    setSelectedValue: (value: IValue) => void
    values: IValue[]
}

export const GamesFilterField: FC<GamesFilterField> = ({selectedValue, setSelectedValue, values, title}) => {
    return (
        <div>
            <div className={"text-sm"}>{title}</div>
            <Listbox value={selectedValue} onChange={setSelectedValue}>
                <Listbox.Button
                    className={"flex items-center justify-between bg-gray-100 py-1 px-2 rounded-lg w-full dark:bg-slate-900"}>
                    {selectedValue.title}
                    <ChevronDownIcon className={"w-4 h-4"}/>
                </Listbox.Button>
                <Listbox.Options className={"rounded-lg overflow-hidden bg-gray-100 mt-2"}>
                    {values.map((value) => (
                        <Listbox.Option key={value.id} value={value} as={Fragment}>
                            {({active, selected}) => (
                                <li
                                    className={"flex items-center py-1 px-2 cursor-pointer " + `${
                                        active
                                            ? 'bg-blue-600 text-white dark:text-slate-900 dark:bg-sky-500'
                                            : 'bg-gray-100 text-black dark:bg-slate-900 dark:text-white'
                                    }`}
                                >
                                    <div className={"w-4 h-4"}>
                                        {selected && <CheckIcon className={"w-4 h-4"}/>}
                                    </div>
                                    <div className={"ml-2"}>
                                        {value.title}
                                    </div>
                                </li>
                            )}
                        </Listbox.Option>
                    ))}
                </Listbox.Options>
            </Listbox>
        </div>
    );
}
