package com.jawas.model;

public class Planet
{
    private long id;
    private String name;
    private String type;
    private Integer size;

    public Planet(long id, String name, String type, Integer size)
    {
        this.id = id;
        this.name = name;
        this.type = type;
        this.size = size;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Integer getSize()
    {
        return size;
    }

    public void setSize(Integer size)
    {
        this.size = size;
    }
}
