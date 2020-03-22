package org.menaphos;

import org.menaphos.action.ActionInvoker;
import org.menaphos.action.impl.skill.gathering.GatheringSkillActionContext;
import org.menaphos.action.impl.skill.gathering.MiningAction;
import org.menaphos.entity.impl.impl.MockPlayer;
import org.menaphos.entity.impl.impl.PlayableCharacter;
import org.menaphos.entity.impl.item.ItemDefinition;
import org.menaphos.event.MenaphosEventManager;
import org.menaphos.io.cache.CrunchifyInMemoryCache;
import org.menaphos.io.fs.Extension;
import org.menaphos.io.fs.FileRequest;
import org.menaphos.io.fs.MenaphosFileSystem;
import org.menaphos.io.fs.impl.DefaultFileSystem;
import org.menaphos.io.fs.repository.*;
import org.menaphos.log.EventLog;
import org.menaphos.log.EventLogRepository;
import org.menaphos.log.EventLogRepositoryManager;
import org.menaphos.log.npc.metric.*;
import org.menaphos.model.command.Command;
import org.menaphos.model.command.CommandRepository;
import org.menaphos.entity.impl.item.Item;
import org.menaphos.entity.impl.item.ItemDefinitionRepository;
import org.menaphos.model.finance.transaction.currency.Currency;
import org.menaphos.model.finance.transaction.currency.CurrencyFactory;
import org.menaphos.model.finance.transaction.currency.CurrencyRepository;
import org.menaphos.model.loot.*;
import org.menaphos.model.skill.gathering.GatheringSkill;
import org.menaphos.model.skill.gathering.GatheringSkillFactory;
import org.menaphos.model.skill.gathering.mining.MiningSkillFactory;
import org.menaphos.model.skill.item.SkillItemFactory;
import org.menaphos.model.skill.item.tool.impl.GatheringToolFactory;
import org.menaphos.model.skill.nodes.context.NodeContextFactory;
import org.menaphos.model.skill.nodes.context.impl.test.OreContextFactory;
import org.menaphos.model.task.Task;
import org.menaphos.model.world.content.shop.Shop;
import org.menaphos.model.world.content.shop.ShopContext;
import org.menaphos.model.world.content.shop.factory.ShopFactory;
import org.menaphos.model.world.content.shop.model.merchandise.Merchandise;
import org.menaphos.model.world.content.shop.model.merchandise.MerchandiseRepository;
import org.menaphos.model.world.content.shop.model.merchandise.Stock;
import org.menaphos.model.world.content.shop.repository.ShopRepository;
import org.menaphos.model.world.location.Location;
import org.phantasye.RepositoryManager;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class Menaphos {

    public static enum Repository {
        CHARACTER_DETAILS("character-details"),
        ITEM_DEFINITION("item-definitions"),
        SHOP("shop-data"),
        CURRENCY("currencies"),
        MERCHANDISE("merchandise-data"),
        COMMANDS("command-data"),
        LOGGING("log-data"),
        NPC_METRICS("npc-metrics"),
        NPC_METRIC_AVERAGES("npc-metric-averages"),
        LOOTABLE_NPC("lootable-npc-data"),
        LOOTABLE_OBJECT("lootable-object-data"),
        LOOTABLE_ITEM("lootable-item-data"),
        SLAYER_MONSTER("slayer-monster-data"),
        SLAYER_MASTER("slayer-master-data"),
        SLAYER_UNLOCK("slayer-unlock-data"),
        TASK_LOCATION("task-location-data"),
        BOSS_TASK("boss-tasks");

        private final String fileName;

        private Repository(String fileName) {
            this.fileName = fileName;
        }

        public String getFileName() {
            return fileName;
        }
    }

    public static void main(String[] args) {
        PlayableCharacter player = new MockPlayer();
        player.addItemToInventory(10, 1);
        GatheringSkill skill = GatheringSkillFactory.getSkill(new MiningSkillFactory(player));

        skill.perform(
                new MiningAction(
                        NodeContextFactory.getContext(new OreContextFactory(1)),
                        new GatheringSkillActionContext(
                                player,
                                new Location(0, 0),
                                SkillItemFactory.getItem(new GatheringToolFactory(skill.getTool()))
                        )));

//        LootableObjectRepositoryManager.getInstance().getRepository().create(lootableObject);
//        LootableObjectRepositoryManager.getInstance().updateRepository();

//        RenewableNodeRepositoryManager.getInstance().getRepository().create(new DummyOre(1,1,0,500,10,5));
//        GatheringNodeRepositoryManager.getInstance().getRepository().create(new DummyNode(2,1,1,50));
//        RenewableNodeRepositoryManager.getInstance().updateRepository();
//        GatheringNodeRepositoryManager.getInstance().updateRepository();

//        NodeContextFactory.getContext(new RenewableNodeContextFactory(1)).respawn();


//        JsonConverter jsonConverter = new JsonConverter();
//        PlayerDetails playerDetails = new PlayerDetails(1l);
//        playerDetails.setLootableItem(new LootableItem(1,"TEST"));
//        JsonObject jsonObject = jsonConverter.convertToJsonObject(playerDetails);
//
//        System.out.println(jsonObject);
//
//        jsonObject.remove("lootableItem");
//
//        System.out.println(jsonObject);
//        DatabaseAcessManager.getInstance().createNewDatabase("test.db");
//        final AbstractDataAcessObject<PlayerDetails> playerDetailsDataAcessObjectBase = new PlayerDetailsDataAccessObjectImpl<>();

//        playerDetailsDataAcessObjectBase.getDatabaseServiceProvider().createTable(
//                "basic",
//                new QueryParameter("id",SqlDataType.BIGINT,QueryParameter.PRIMARY_KEY)
//        );

//        playerDetailsDataAcessObjectBase.create(new PlayerDetails(15l));

//        createCurrency(995, Currency.Type.ITEM);
//        final LootableContainer lootableContainer = LootFactory.getLootableNpc(5091);
//        final AdjustableNumber<Integer> common = new AdjustableInteger(0);
//        final AdjustableNumber<Integer> uncommon = new AdjustableInteger(0);
//        final AdjustableNumber<Integer> rare = new AdjustableInteger(0);
//        final AdjustableNumber<Integer> veryRare = new AdjustableInteger(0);
//        final AdjustableNumber<Integer> legendary = new AdjustableInteger(0);
//        final Range commonRange = new Range(68,100);
//        final Range uncommonRange = new Range(37,67);
//        final Range rareRange = new Range(16,36);
//        final Range veryRareRange = new Range(5,15);
//        final Range legendaryRange = new Range(1,4);
//        for (int i = 0; i < 10000; i++) {
//            Loot loot = lootableContainer.testOpen(400);
//            double chance = loot.getPercentDrop() * 100;
//            if(Range.within(chance,commonRange))
//                common.increment();
//            else if(Range.within(chance,uncommonRange))
//                uncommon.increment();
//            else if(Range.within(chance,rareRange))
//                rare.increment();
//            else if(Range.within(chance,veryRareRange))
//                veryRare.increment();
//            else if(Range.within(chance,legendaryRange))
//                legendary.increment();
//        }
//        System.out.println("COMMON: " + common.value());
//        System.out.println("UNCOMMON: " + uncommon.value());
//        System.out.println("RARE: " + rare.value());
//        System.out.println("VERY RARE: " + veryRare.value());
//        System.out.println("LEGENDARY: " + legendary.value());
//        final List<Loot> lootList = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            lootList.add(LootFactory.getLootableNpc(412).open(50.0d));
//        }
//        System.out.println("================RESULTS===================");
//        int common =
//                (int) lootList.stream().filter(loot->Range.within(loot.getPercentDrop() * 100,new Range(70,100))).count();
//        int uncommon =
//                (int) lootList.stream().filter(loot->Range.within(loot.getPercentDrop() * 100,new Range(40,69))).count();
//        int rare =
//                (int) lootList.stream().filter(loot->Range.within(loot.getPercentDrop() * 100,new Range(10,39))).count();
//        int veryRare =
//                (int) lootList.stream().filter(loot->Range.within(loot.getPercentDrop() * 100,new Range(5,9))).count();
//        int legendary =
//                (int) lootList.stream().filter(loot->Range.within(loot.getPercentDrop() * 100,new Range(1,4))).count();
//        System.out.println("COMMON: " + common);
//        System.out.println("UNCOMMON: " + uncommon);
//        System.out.println("RARE: " + rare);
//        System.out.println("VERY RARE: " + veryRare);
//        System.out.println("LEGENDARY: " + legendary);
//        NpcMetricAverageFactory.updateMetricAverage(NpcMetricFactory.getMetricForNpc(401));
//        final Random random = new Random();
//        for (int i = 0; i < 10000; i++) {
//            int npc = random.nextInt(1000);
//            NpcMetric metric = NpcMetricFactory.getMetricForNpc(npc);
//            metric.getKills().increment();
//            metric.getKillTimeList().add(1d);
//            metric.updateAverage();
//        }
//        LootFactory.getLootableNpc(412).open(90.0d);
//        LootFactory.getLootableNpc(100).getLoot().forEach(id-> System.out.println(id.getItem().getId()));
//        final RepositoryManager<Command,CommandRepository> rm = new CommandRepositoryManager();
//        Command command = new Command("test");
//
//        command.getAliases().add("t");
//        command.getAliases().add("t2");
//
//        command.getOptions().add(new Command.CommandOption("arg1","a1",false,false,"test"));
//
//        command.getPermittedRanks().add(1);
//
//        rm.getRepository().create(command);

//        rm.updateRepository();
//        Menaphos.getInstance().init();


    }

    private static Shop getShop(int id) {
        return ShopFactory.getShop(id);
    }

    private static void createShop() {
        final RepositoryManager<Shop, ShopRepository> rm = new ShopRepositoryManager();
        final ShopContext context = new ShopContext.ShopContextBuilder(1)
                .withName("Test Shop")
                .withProfitMargin(.15f)
                .isPremium(false)
                .doesResale(true)
                .withRefreshRate(10000)
                .usesCurrency(CurrencyFactory.getCurrency("995"))
                .build();
        final Shop shop = new Shop(context);

        shop.add(1040, 10);

        rm.getRepository().create(shop);

        rm.updateRepository();
    }

    private static void createCurrency(Object id, Currency.Type type) {
        final RepositoryManager<Currency, CurrencyRepository> rm = new CurrencyRepositoryManager();

        rm.getRepository().create(new Currency(String.valueOf(id), type));

        rm.updateRepository();
    }

    private static void createMerch(int id, int onHand, int cap) {
        final RepositoryManager<Merchandise, MerchandiseRepository> merchRm = getMerchandiseRepositoryManager();
        merchRm.getRepository().create(new Merchandise(new Stock(new Item(id), cap, onHand)));
        merchRm.updateRepository();
    }

    private static Menaphos instance = null;

    private final MenaphosFileSystem fileSystem;
    private final CrunchifyInMemoryCache<String, File> cache;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final MenaphosEventManager menaphosEventManager;
    private final ActionInvoker actionInvoker;

    public static Menaphos getInstance() {
        if (instance == null)
            instance = new Menaphos();
        return instance;
    }

    private Menaphos() {
        this.cache = new CrunchifyInMemoryCache<>(300, 500, 6);
        this.fileSystem = new DefaultFileSystem(cache);
        this.menaphosEventManager = new MenaphosEventManager();
        this.actionInvoker = new ActionInvoker();
        this.init();
    }

    public void init() {
        if (fileSystem.init()) {
            Arrays.stream(Repository.values()).forEach(repository -> fileSystem.patch(this.requestRepository(repository)));
        }

    }

    public FileRequest requestRepository(Repository repository) {
        return new FileRequest.FileRequestBuilder(fileSystem)
                .inDirectory("system")
                .inDirectory("repositories")
                .withFileName(repository.getFileName())
                .withExtension(Extension.JSON)
                .build();
    }

    public static RepositoryManager<NpcMetricAverage, NpcMetricAverageRepository> getMetricAverageRepositoryManager() {
        return new NpcMetricAverageRepositoryManager();
    }

    public static RepositoryManager<LootableItem, LootableItemRepository> getLootableItemRepositoryManger() {
        return LootableItemRepositoryManager.getInstance();
    }

    public static RepositoryManager<LootableObject, LootableObjectRepository> getLootableObjectRepositoryManager() {
        return LootableObjectRepositoryManager.getInstance();
    }

    public static RepositoryManager<LootableNpc, LootableNpcRepository> getLootableNpcRepositoryManager() {
        return LootableNpcRepositoryManager.getInstance();
    }

    public static RepositoryManager<ItemDefinition, ItemDefinitionRepository> getItemDefinitionRepositoryManager() {
        return ItemDefinitionRepositoryManager.getInstance();
    }

    public static RepositoryManager<Shop, ShopRepository> getShopDefinitionRepositoryManager() {
        return new ShopRepositoryManager();
    }

    public static RepositoryManager<Currency, CurrencyRepository> getCurrencyRepositoryManager() {
        return new CurrencyRepositoryManager();
    }

    public static RepositoryManager<Merchandise, MerchandiseRepository> getMerchandiseRepositoryManager() {
        return new RepositoryManager<Merchandise, MerchandiseRepository>(Menaphos.getInstance().requestRepository(Repository.MERCHANDISE).getAbsolutePath(), MerchandiseRepository.class);
    }

    public static RepositoryManager<Command, CommandRepository> getCommandRepositoryManager() {
        return new CommandRepositoryManager();
    }

    public static RepositoryManager<EventLog, EventLogRepository> getEventLogRepositoryManager() {
        return new EventLogRepositoryManager();
    }

    public static RepositoryManager<NpcMetric, NpcMetricRepository> getNpcMetricRepositoryManager() {
        return NpcMetricRepositoryManager.getInstance();
    }

//    public static<T,R extends AbstractJsonRepository<T>> RepositoryManager<T,R> getRepositoryManagerFor(Repository repository) {
//        switch (repository) {
//            case ITEM_DEFINITION:
//                return new RepositoryManager<ItemDefinition,ItemDefinitionRepository>(Menaphos.getInstance().requestRepository(repository).getAbsolutePath(), ItemDefinitionRepository.class);
//            case SHOP:
//                return new RepositoryManager<>(Menaphos.getInstance().requestRepository(repository).getAbsolutePath(), ShopRepository.class);
//            case CURRENCY:
//                return new CurrencyRepositoryManager();
//            case MERCHANDISE:
//                return new RepositoryManager<>(Menaphos.getInstance().requestRepository(repository).getAbsolutePath(), MerchandiseRepository.class);
//            case COMMANDS:
//                return new RepositoryManager<>(Menaphos.getInstance().requestRepository(repository).getAbsolutePath(), CommandRepository.class);
//        }
//        return null;
//    }

    public ActionInvoker getActionInvoker() {
        return actionInvoker;
    }

    public MenaphosFileSystem getFileSystem() {
        return fileSystem;
    }

    public void scheduleTask(Task task) {
        scheduler.schedule(task, task.getDelay(), TimeUnit.MILLISECONDS);
    }
}
