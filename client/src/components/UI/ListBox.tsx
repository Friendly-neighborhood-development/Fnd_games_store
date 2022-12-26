import React, {FC} from 'react';
import {Listbox} from "@headlessui/react";
import {ChevronDownIcon} from "@heroicons/react/20/solid";

interface ListBoxProps {
    children: React.ReactNode,
    selectedValue: any,
    setSelectedValue: (arg0: any) => void,
    values: Array<any>
}

export const ListBox: FC<ListBoxProps> = ({children, selectedValue, setSelectedValue, values}) => {
    return (
        <Listbox value={selectedValue} onChange={setSelectedValue}>
            <Listbox.Button
                className={"flex items-center border border-gray-300 h-10 px-4 space-x-1.5 text-slate-600 rounded-3xl hover:bg-gray-200/30 dark:hover:bg-slate-500/50 dark:border-slate-600 dark:text-slate-300 dark:bg-slate-800"}>
                {children}
                <ChevronDownIcon className={"w-3 h-3"}/>
            </Listbox.Button>
            <Listbox.Options
                className={"absolute top-full right-0 mt-8 lg:mt-8 w-36 bg-white rounded-lg py-1 shadow-xl overflow-hidden dark:text-slate-300 dark:bg-slate-800"}>
                {values.map((value) => (
                    <Listbox.Option
                        key={value.id}
                        value={value}
                    >
                        {({active, selected}) => (
                            <div
                                className={`px-2 py-1 cursor-pointer 
                                ${active ? "bg-gray-100 dark:bg-slate-700 " : ""}
                                ${selected ? "text-blue-600 dark:text-sky-500" : ""}`}
                            >
                                <div className={"flex capitalize"}>
                                    <value.Icon className={"w-6 h-6 mr-2"}/>
                                    {value.title}
                                </div>
                            </div>
                        )}
                    </Listbox.Option>
                ))}
            </Listbox.Options>
        </Listbox>
    )
}